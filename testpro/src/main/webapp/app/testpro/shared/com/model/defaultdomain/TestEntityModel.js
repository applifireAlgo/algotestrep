Ext.define('Testpro.testpro.shared.com.model.defaultdomain.TestEntityModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "pk",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "fName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});