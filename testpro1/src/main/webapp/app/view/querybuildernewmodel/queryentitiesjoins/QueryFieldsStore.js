Ext.define('Testpro1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testpro1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
