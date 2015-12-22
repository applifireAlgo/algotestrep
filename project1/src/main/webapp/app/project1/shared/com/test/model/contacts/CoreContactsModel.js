Ext.define('Project1.project1.shared.com.test.model.contacts.CoreContactsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "contactId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "titleid",
          "reference": "Title",
          "defaultValue": ""
     }, {
          "name": "firstName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "middleName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativelanguagecode",
          "reference": "Language",
          "defaultValue": ""
     }, {
          "name": "nativeTitle",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeFirstName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeMiddleName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "nativeLastName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "genderid",
          "reference": "Gender",
          "defaultValue": ""
     }, {
          "name": "dateofbirth",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "age",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "approximateDOB",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "emailId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "phoneNumber",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "Timezone",
          "reference": "TimezoneModel"
     }, {
          "name": "CommunicationData",
          "reference": "CommunicationDataModel"
     }, {
          "name": "Address",
          "reference": "AddressModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});