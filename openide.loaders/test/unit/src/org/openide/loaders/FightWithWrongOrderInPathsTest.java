/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.openide.loaders;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.junit.Log;
import org.netbeans.junit.RandomlyFails;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.CookieSet;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;


/**
 * Java vs. Form in wrong order. Based on KitFox's report in #73037.
 *
 * @author Jaroslav Tulach
 */
public class FightWithWrongOrderInPathsTest extends LoggingTestCaseHid
implements DataLoader.RecognizedFiles {

    private CharSequence log;
    private FileObject f0;
    private FileObject f1;
    private FileObject f2;
    private FileObject root;
    
    public FightWithWrongOrderInPathsTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        log = Log.enable("org.openide.loaders", Level.SEVERE);

        init();
        
        AddLoaderManuallyHid.addRemoveLoader(JavaDataLoader.getLoader(JavaDataLoader.class), true);
        FileUtil.setMIMEType("java", "text/x-java");
        FileUtil.setMIMEType("formKit", "application/x-form");

        root = FileUtil.createFolder(FileUtil.createMemoryFileSystem().getRoot(), "test");

        f0 = FileUtil.createData(root, "j1.java");
        f1 = FileUtil.createData(root, "f.formKit");
        f2 = FileUtil.createData(root, "f.java");
        
        assertEquals("Right mime type", "text/x-java", f2.getMIMEType());
        FormKitDataLoader.cnt = 0;
    }

    @Override
    protected void tearDown() throws Exception {
        AddLoaderManuallyHid.addRemoveLoader(JavaDataLoader.getLoader(JavaDataLoader.class), false);
    }


    static void init() throws IOException {
        FileObject fo = FileUtil.getConfigRoot();
        FileObject data = FileUtil.createData(fo, 
            "Loaders/text/x-java/Factories/" + 
            FormKitDataLoader.class.getName().replace('.', '-') + ".instance"
        );
        FileObject data2 = FileUtil.createData(fo, 
            "Loaders/application/x-form/Factories/" + 
            FormKitDataLoader.class.getName().replace('.', '-') + ".instance"
        );

        Object obj = Lookups.forPath("Loaders/text/x-java").lookup(FormKitDataLoader.class);
        assertNotNull("lookup registered", obj);

        obj = Lookups.forPath("Loaders/application/x-form").lookup(FormKitDataLoader.class);
        assertNotNull("lookup registered", obj);
    }
    
    
    @Override
    protected Level logLevel() {
        return Level.INFO;
    }

    public void testRecognizeToDefault() throws Exception {
        DataObject obj0 = DataObject.find(f0);
        DataObject obj1 = DataObject.find(f1);
        DataObject obj2 = DataObject.find(f2);

        assertEquals(DataLoader.getLoader(JavaDataLoader.class), obj0.getLoader());
        assertEquals(DataLoader.getLoader(JavaDataLoader.class), obj2.getLoader());


        if (obj1 == obj2) {
            fail("They should be different: " + obj1);
        }

        assertEquals("It is default loader", obj1.getLoader(), DataLoaderPool.getDefaultFileLoader());
        if (FormKitDataLoader.cnt == 0) {
            fail("Form loader shall be consulted");
        }
    }

    @RandomlyFails // NB-Core-Build #7947 and in manual runs: Form loader shall be consulted
    public void testRecognizeJavaFirstFormKitLater() throws Exception {
        DataObject obj0 = DataObject.find(f0);
        DataObject obj2 = DataObject.find(f2);
        DataObject obj1 = DataObject.find(f1);

        assertEquals(DataLoader.getLoader(JavaDataLoader.class), obj0.getLoader());
        assertEquals(DataLoader.getLoader(JavaDataLoader.class), obj2.getLoader());

        if (obj1 == obj2) {
            fail("They should be different: " + obj1);
        }

        assertEquals("It is default loader", obj1.getLoader(), DataLoaderPool.getDefaultFileLoader());
        if (FormKitDataLoader.cnt == 0) {
            fail("Form loader shall be consulted");
        }
    }
    
    // disabling - now the order is according to FileObject
    public void _testGetFolderChildren() throws Exception {
        DataFolder folder = DataFolder.findFolder(root);
        DataObject[] arr = folder.getChildren();
        assertEquals("Two object returned", 3, arr.length);
        
        assertEquals("1st", f2, arr[0].getPrimaryFile());
        assertEquals("2nd", f1, arr[1].getPrimaryFile());
        assertEquals("3rd", f0, arr[2].getPrimaryFile());
        if (FormKitDataLoader.cnt == 0) {
            fail("Form loader shall be consulted");
        }
        
    }



    public void markRecognized(FileObject fo) {
    }


    public static class JavaDataLoader extends MultiFileLoader {

        public static final String JAVA_EXTENSION = "java";

        public JavaDataLoader() {
            super(JavaDO.class.getName());
        }

        protected JavaDataLoader(String s) {
            super(s);
        }

        protected FileObject findPrimaryFile(FileObject fo) {
            if (fo.hasExt(JAVA_EXTENSION)) {
                return fo;
            } else {
                return null;
            }
        }

        protected MultiDataObject createMultiObject(FileObject primaryFile) throws DataObjectExistsException, IOException {
            return new JavaDO(primaryFile, this);
        }

        protected MultiDataObject.Entry createPrimaryEntry(MultiDataObject obj, FileObject primaryFile) {
            return new FileEntry(obj, primaryFile);
        }

        protected MultiDataObject.Entry createSecondaryEntry(MultiDataObject obj, FileObject secondaryFile) {
            throw new UnsupportedOperationException();
        }

        static class JavaDO extends MultiDataObject {
            public JavaDO(FileObject fo, JavaDataLoader l) throws DataObjectExistsException {
                super(fo, l);
            }
        }
    }


    public static class FormKitDataLoader extends JavaDataLoader {
        private static Logger LOG = Logger.getLogger(FormKitDataLoader.class.getName());

        public static final String REQUIRED_MIME = "text/x-java";
        public static final String FORM_EXTENSION = "formKit"; // NOI18N

        private static final long serialVersionUID = 1L;
        static int cnt;

        public FormKitDataLoader()
        {
            super(FormKitDataObject.class.getName());
        }

        @Override
        protected String defaultDisplayName()
        {
            return NbBundle.getMessage(FormKitDataLoader.class, "LBL_FormKit_loader_name");
        }

        @Override
        protected String actionsContext()
        {
            return "Loaders/" + REQUIRED_MIME + "/Actions";
        }

        @Override
        protected FileObject findPrimaryFile(FileObject fo)
        {
            LOG.info("FormKitDataLoader.findPrimaryFile(): " + fo.getNameExt());
            cnt++;
            
            String ext = fo.getExt();
            if (ext.equals(FORM_EXTENSION))
            {
                return FileUtil.findBrother(fo, JAVA_EXTENSION);
            }
            if (ext.equals(JAVA_EXTENSION) && FileUtil.findBrother(fo, FORM_EXTENSION) != null)
            {
                return fo;
            }
            return null;
        }

        @Override
        protected MultiDataObject createMultiObject(FileObject primaryFile) throws DataObjectExistsException, java.io.IOException
        {
            LOG.info("FormKitDataLoader.createMultiObject(): " + primaryFile.getNameExt());

            return new FormKitDataObject(FileUtil.findBrother(primaryFile, FORM_EXTENSION),
                    primaryFile,
                    this);
        }

        @Override
        protected MultiDataObject.Entry createSecondaryEntry(MultiDataObject multiDataObject, FileObject fileObject)
        {
            if (fileObject.getExt().equals(FORM_EXTENSION))
            {
                FileEntry formEntry = new FileEntry(multiDataObject, fileObject);
                return formEntry;
            }
            return super.createSecondaryEntry(multiDataObject, fileObject);
        }

        final class FormKitDataObject extends JavaDO {
            FileEntry formEntry;

            public FormKitDataObject(FileObject ffo, FileObject jfo, FormKitDataLoader loader) throws DataObjectExistsException, IOException
            {
                super(jfo, loader);
                formEntry = (FileEntry)registerEntry(ffo);

                CookieSet cookies = getCookieSet();
                //cookies.add((Node.Cookie) DataEditorSupport.create(this, getPrimaryEntry(), cookies));
            }


        }
    }

}
