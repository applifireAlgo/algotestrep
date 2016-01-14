Ext.define('Testpro1.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro1.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testpro1.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
