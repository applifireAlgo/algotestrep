package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AppCustomerRepository;
import com.app.shared.customers.AppCustomer;
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
import com.app.shared.customers.AppCustomerCategory;
import com.app.server.repository.AppCustomerCategoryRepository;
import com.app.shared.customers.AppCustomerType;
import com.app.server.repository.AppCustomerTypeRepository;
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("uqasiO7Jxc7wkdKh8v0WO7i0nbB43IaBlXEBXX7SWhxz5taRjk");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("GS58kPl32AkQAFxzNt3Tap6WIAl0ulkVIk6WmgfxrX8kYCVa7U");
            appcustomertype.setDefaults(0);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(32);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("baZ7zH4wMSZcKWSOPdx5dhn3FJYhV9i0hksrWPbW22ChEuirJN");
            corecontacts.setFirstName("6aSaHJRfvmU2zWLvSFbVNw1QSskxVYvGOo3IAgjL7PLZSTlLGV");
            Gender gender = new Gender();
            gender.setGender("uQp8mJN7hmKsmjKlfxcchoUS2iGnkOEQLqibKkHvdmA7U403Vo");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("qp");
            language.setAlpha3("ctn");
            language.setAlpha4("ha8t");
            language.setAlpha4parentid(6);
            language.setLanguage("nyD9xZvoKMGuMLRThAJksyl55emx81qkQb4i0PZkI4QOcqPKbD");
            language.setLanguageDescription("nxTxcbIT3FAT3XJlwbAxM6iWne297T8GLi0tUCpYc3Abqrkd8v");
            language.setLanguageIcon("mVSq4ffFjMfEkOhXQZq0c5C8iLt139d9Fp19ylABHVixkB1IbW");
            language.setLanguageType("mSB0UBl5wtdTPd5N3v5XMVSoWTz1Biig");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("bVwYWfzgQiQyHDQNOJflLR4PhorAiRXuOQ8VPCpYvsYf2AgBwN");
            timezone.setCountry("qKDz0oI3fGdremMz4udB0Mnz53KBqsXxP8XaeuyiscCZgRdJuf");
            timezone.setGmtLabel("tsmEepiBkCFuokqJlxK9pidJe9TwIyDZAVI0BUIAiXmKwHMVZZ");
            timezone.setTimeZoneLabel("DFMiYxG7Klftzr3SQOcZ1BptxUb572o6zFtwJp1OTkU5E5lEKr");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("qyHHrPCaS0g4cvUtrtNSI5oPSVdmNPGfD4sObD0pfpYnCYpFwV");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(0);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("OSW2gISwTkZfSgm4E5UsPkFxnX8FfQla1lNdBaf1CIX4QZEyCA");
            corecontacts.setFirstName("7RJWQZwY1Uw8onJ5ox4uj0WoqXOf13nZgFBfma6bXR7DKUBrJr");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("Avc0x0JbONehVM3gQig2an0oaUIOInHplATXZM4TJDi1bzwooh");
            corecontacts.setMiddleName("VxtbZuMIEY7rSnHZLy6WTQOOtB2bdCU6iiEKCrdmnWlNx6IlSC");
            corecontacts.setNativeFirstName("8eV7xyhH0hd3b7SXXn1p8Qi6chtlNTN878Si9zlYdnJzN60zTK");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("2LG9SyXoNpQlMyZ0fkEwbQbP7jvHb924U9dvIwPkQUzkfj7utf");
            corecontacts.setNativeMiddleName("MLUYvPck0B1B4EXlVyHidm9Sw5VKqdj4uJ6S9EN9AOQ4ps0SrR");
            corecontacts.setNativeTitle("2jCwbsz086EbwTM5PpGOkjn2LOYOzt5TExGPUiYRTiicIVZKNg");
            corecontacts.setPhoneNumber("RZCNfouTyR7milLbEGoQ");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("Hyc6KgFin16z72FquQHIf7nsxON1LZEbxYAGOEANzWgcIDIyH4");
            appcustomer.setCustomerStatus(0);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("SsPaytoH6KUU7fT9N1ql8vzKeixSg7OhFjJUJFdspuuHDp8DKk");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
