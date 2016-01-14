package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("s1DNrky7AMkeLcTVA7aQUYGqtIuaF3tALC5ed3t4SrLqqcmxO0");
            addresstype.setAddressTypeDesc("1ROFoyg8F9oppPMsJOPU4gzN4H3ptzQMRMIDWqdX2Nw4QcF7kY");
            addresstype.setAddressTypeIcon("DvhE1pdqPFlD8sEWMtlG3F3LZWHhUYwtvn39pDikHsiBTnt5V1");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("fYoq0V9cHYQWOmDBaD8BVu7vcAPEIMoW");
            city.setCityDescription("1Ro6zY4xgBk9Nufx8Z8vgLXQW3ZZ5eNpHhML8JR8eNajLbHvOn");
            city.setCityFlag("HIRGybaO3SgQV6mWxgR9jvWQmySwkqv3oESlDefWfzr7M2WcPS");
            city.setCityLatitude(0);
            city.setCityLongitude(5);
            city.setCityName("dbah1WRkYOJUO1xPhrrKHpQde3zUcDMfDvYJnHTkzAGd21uM0d");
            Country country = new Country();
            country.setCapital("piPDCvHRkE4mO6wNu0UR19zRx388GZMT");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(0);
            country.setCountryCode1("Phm");
            country.setCountryCode2("pmA");
            country.setCountryFlag("edShQFPxp7BOvEiYmIu7ozAHUeukIFwj9Xzy7vBilnHtXlswv8");
            country.setCountryName("aVxKM0UUd8FY9MuiViapds68ileDeFoRtyAFrwG1Cq4N8zEwyg");
            country.setCurrencyCode("Ssn");
            country.setCurrencyName("DffvZnaOfBgNjtxCbmXlHtyorezgHFLnO8fDyzy2zU82cerOc6");
            country.setCurrencySymbol("5qoE0qQUwHMq8ohLhQtsxrRiNiUGZkNg");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("vzp1s36EV7Txtspdrq7fWlPc9HS8O5PoLAnK1SLWuuH5kdtZX1");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(4);
            state.setStateCode(1);
            state.setStateCodeChar2("7ApHxUkLYU1wbGcvUzKYH7jsHSeLVDGh");
            state.setStateCodeChar3("caE7pK0WnrvMeauAMgNylAJFun5BpPGM");
            state.setStateDescription("OIs4WcqUEJSGrBZ3JXkF4lA2pZdByeFUUV2oqN0cyyvfEhJAMs");
            state.setStateFlag("4AmawNiUnhQIW4twtuLwt8GUbc0MtpdyOEeqOz8H0oT4hbk9Wl");
            state.setStateName("LxL1nH8ZdTQsO55ZHUiQjm9xtpavk01suzGXkVRjv5NSgo427U");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("Est6V95FicQOdDh6x5wlCFHFJpR0URkr");
            city.setCityDescription("QhnzY6uw7vyliUo9hczo3JOENWqcaY1o0dIh5oVTE076uivTC8");
            city.setCityFlag("nlVotV5mX3GoIHNXVRbjYXCpHdjYg5D41auehh03hJWZLL2wNd");
            city.setCityLatitude(10);
            city.setCityLongitude(9);
            city.setCityName("spqvKpk83IeBzDD9YRsvWzNs2lJlhiLRU09otrLfdl5ayigDop");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("r4SAjhZOFPuihfVJSe8Y37pVuJIW0aR8xNkYnDJXkZRyGL8NpV");
            address.setAddress2("yBhPB6vFpFJWQmw80GUY1OVREkV1GyRGsIlfjMHfzLFPy8sFiY");
            address.setAddress3("vHcXailOGrRHMTOMqh34yu0VvmyFXYDUl2ofgLULKgEdCuxdcJ");
            address.setAddressLabel("9R4yshtvb1B");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("E9rF8Deqg5H5scRehJH7jweYOPM4plxeFWa1SbqKr4cpWusyS5");
            address.setLongitude("bs0LbQKSCrExy67laPmYVOfyuY75xaz9ZdpgwJM1Mpk2Gjuamy");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("srw9hW");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("IjbWu6QJ0INCkoS7g55zp6r22uHzdOpCfkks3zKXBD6QGimYhA");
            address.setAddress2("FH5DQkJtSDmeFyduff2BVFKI7dBxJL888hi8VYsBObYDaGD4Pg");
            address.setAddress3("xkDBKKpkYDaXLyb1Hr2e5qJss2kocUjp1RtxAAnAttku6trR2T");
            address.setAddressLabel("cpNU4cgZZWn");
            address.setLatitude("D5TCPDBjL5GdzKSR7VoZpdMR8Eq54rQzn0YGe1HYypZ8LhXrSn");
            address.setLongitude("pSfZ9qQd0xQbUAVJ1wWTvVl5UqTKzHPaosudJpBRh60dedtw4b");
            address.setVersionId(1);
            address.setZipcode("Ms2fqQ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
