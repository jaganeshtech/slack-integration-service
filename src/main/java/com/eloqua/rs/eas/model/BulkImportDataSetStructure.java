/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author pmanoor
 */
public class BulkImportDataSetStructure {
     public BulkImportDataSetStructure(){
            
        }
        public Map<String, String> fields;
        public String importPriorityUri;
        public String identifierFieldName;
        public boolean isSyncTriggeredOnImport;
        public long kbUsed;
        public String name;
        public int secondsToRetainData;
      //  public int secondsToAutoDelete;
        public List<SyncAction> syncActions;
        public RuleType updateRule;
        public String uri;
    
}
