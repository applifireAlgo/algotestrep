package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CurrencyRepository;
import com.app.shared.location.Currency;
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
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CurrencyTestCase {

    @Autowired
    private CurrencyRepository<Currency> currencyRepository;

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
            Country country = new Country();
            country.setCapital("BvNWPQteDNhUtmG1hntVfXEdRuAdQvfy");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(11);
            country.setCountryCode1("HBh");
            country.setCountryCode2("Mhz");
            country.setCountryFlag("bPDDxbJ5IfxjlcCp4YB1nn9shdoA41JXhPWimByXAxQZ2NfiOF");
            country.setCountryName("v8kJg8H4PYtArdCaz9XG6uhRZNSCSX2OsqvgzVFNzwpMEGopci");
            country.setCurrencyCode("Ii9");
            country.setCurrencyName("vBlJry3UcW741QmcyUuqZuY0TixJPPvvlgjsQwsaiFx3x5cS45");
            country.setCurrencySymbol("G01XZSKJGssaFcazKnweaY8QqO9CiW53");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Currency currency = new Currency();
            currency.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            currency.setCurrencyCode("IOABrGWWF6uDzyIYwfdWQTUOKQNd2tulcfAoL1ACMGfFjc8GNj");
            currency.setUnicodeDecimal("rmsNxn3hdgdOC8bLl8YuG8cWrFwmiJb7TYiasuXXCILfoPWuWT");
            currency.setUnicodeHex("lnXzHzT7hNswoLPYh5Du9XYIh8TpFEKfbFkyYdRiy6YDSTBAhj");
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            currency.setEntityValidator(entityValidator);
            currency.isValid();
            currencyRepository.save(currency);
            map.put("CurrencyPrimaryKey", currency._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            Currency currency = currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
            currency.setCurrencyCode("TaJ7Z2llxd9a4JRiRQ4eyU6BzRblwE9LlSroSZ9JWDSZS8J89H");
            currency.setUnicodeDecimal("plisXzwv0si56p3orsxjxJhWrFmwsG5sNIdcnUiSvGXJGDerPT");
            currency.setUnicodeHex("KZk0HUpAAKLbLPrglv7GjhEqGnALlqvIbfigt0leZ72EMLK9aX");
            currency.setVersionId(1);
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            currencyRepository.update(currency);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Currency> listofcountryId = currencyRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.delete((java.lang.String) map.get("CurrencyPrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
