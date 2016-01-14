Ext.define('Testpro1.view.databrowsercalendar.DBCalendar', {
	extend : 'Testpro1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testpro1.view.databrowsercalendar.DBCalendarController',
	             'Testpro1.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
