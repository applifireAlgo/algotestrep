Ext.define('Testpro1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testpro1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
