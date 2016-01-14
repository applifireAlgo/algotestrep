package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("nRYcaGxBsnWNLullMpek1xb5cdxJcAv5I4TRMDofZs87Sf71O5");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("pl");
            language.setAlpha3("GDP");
            language.setAlpha4("1Rch");
            language.setAlpha4parentid(11);
            language.setLanguage("iYVj71oYabYbDTkBvUloffp3D1zLyFBlBjUkKNfX6qcMfYXvcS");
            language.setLanguageDescription("rBb3TEqVdC4QLE6TR22EYqUzx2YwEAHBX5HNpqTiRf2iscw8x2");
            language.setLanguageIcon("K0NDScg3sPpo2l0vfcMpDRaUoPMTMCY3O7qobjaUDtKV46VBeb");
            language.setLanguageType("LjQKla49zTS7Tumv5t4aRcpCdlEsIe7s");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("acjVKwRY8xdQvyOiUVton9m83Db1ewshd4VmXv2Rj7WgbSgZvD");
            timezone.setCountry("OSMK58zVJ6zQTTBae5rP2GDqOk2ZJ3VLnFXY0aTchHsu6Rlp7G");
            timezone.setGmtLabel("b2VIGsKOQrOvvfbmBGnt1TkuFELpouRynT09lauAxCT3LCYbfe");
            timezone.setTimeZoneLabel("GLAw8s8m7APDQUBjPcJvPV0diPkD7OMsLxnI4WBDWpsPBRBagy");
            timezone.setUtcdifference(6);
            Title title = new Title();
            title.setTitles("tzpx4FFRTgNYLeEj0wtHtaO3uPV0h4wBYNxudU8pEekBG4gn8Y");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(108);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("nc1wpQeHJv7NWnUsirBQruBpcMYK6qOHLIT1VyQmSlA6uOP13K");
            corecontacts.setFirstName("ONyrMmvHWSEuYnecgs2ls8FpdUJhWQZJ1jdbR0ZDMLBKe0m7y0");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("9ft0hIMcTOE4LPU2IjCrjhUp39xDzErm9ssLPjdQuUXHYrvTbP");
            corecontacts.setMiddleName("jtatfnqmTM1krb5Em08JiWrwJovnlaXYGdn1FhpmTTCnwj9Hpm");
            corecontacts.setNativeFirstName("oHpy3OV5ehsrhM4mnGSmhN6h6nKLT1yRDVE30RlSXWY5Fao0kO");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("OiX8BlnSjwxbLa8HdqA5sjd3GwjSGAfvnk6gMATq38OWgIGq25");
            corecontacts.setNativeMiddleName("KYSHTUA6Qh6arooZFhh2hv91aN3gLoHczhdTz1ckxJ6g1rwndo");
            corecontacts.setNativeTitle("rAAYkuq8Jw5LWkznalxdeMpIPhyK2Fr5Swq1EPbsWhOW9pnm8P");
            corecontacts.setPhoneNumber("zOizyvDE2VDcFsrw74fH");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Lri");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("AXS4m8dxU8IR8MGiEJ4L6mnXalebdgMFLVZo6JlI2K0l3Kd5m6");
            communicationgroup.setCommGroupName("KHLjEhc1C9rQaf8e3BJdRCDHnZcu1w126Hrxnb8B1uvk0BDtXu");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("TWJX2itAoyfD6iUkUwSDFDrgpSR4RA2QscdJE2WaTvTua7KF2A");
            communicationtype.setCommTypeName("dNvXAIRQsXrYWAECeB5p82lGNeCxfD082tORMTHCXWwQFuO964");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("1Cn");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("cehuQH0bkK8z4hooiSTeTpQgnu2MCN7KVbfxQCQhdaQIijyOyX");
            address.setAddress2("rkpQZDUAY9mCZkecQa17ZXCQnF8zcYcBqCJjQPOlyZHpd9jP1s");
            address.setAddress3("JbWF0Msl8pykhPI1eoJaT2zruwJBomeZJHFygdIH5TOM0tdqOW");
            address.setAddressLabel("lqrXDaFR9FO");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("XfTXb18K1GxKx5YZjj7FQF0VQGJ3egpYzgDSNZPHmCXqe7qNhy");
            addresstype.setAddressTypeDesc("wQ1cJ4uesgkqGGsnmylFYO7KzmA2UwkOZ4i2jBVJarXGQvHc9k");
            addresstype.setAddressTypeIcon("n7G1pCUgDa3Dh8uRDlIBr2slTngYbwu8OUK8idJCfP0HmeYjiF");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("MlF9g61nS5WWlK3a483MIyY64HHKFPT1");
            city.setCityDescription("Z9Wvjo1B9oBvMXqZB4ZGyIfiM7JPfPXbrkSSH4BJ0d1hvgfw02");
            city.setCityFlag("1sNS7lhLz0PHMgZ5KLOEiJScpxw3c7mxGPPHyWRtU2IQaXbo1o");
            city.setCityLatitude(0);
            city.setCityLongitude(6);
            city.setCityName("Gm0dIjbLlGrlUQ6Ee5eHradMaHc0eYJw6afsPjR0JVf9oFNmJo");
            Country country = new Country();
            country.setCapital("H0yzmZjkoMGdr1lvmU4jvERpDg9iz4xS");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(10);
            country.setCountryCode1("xPS");
            country.setCountryCode2("uDw");
            country.setCountryFlag("8lm0Q6kcYbtbUmHvkxzTp9UFCY0eJXxkeWbh8JkZcL17RPrhnt");
            country.setCountryName("s5j6RaQSIuIQtrOGzjCQk2hYOmqh4O4mGROIGBQ885DeP3bXqx");
            country.setCurrencyCode("7VY");
            country.setCurrencyName("jhzfOiHfmIro65DjwcDdjEY47X6PzZo2aWYENkBP726uZalzNT");
            country.setCurrencySymbol("aLZsk2qVrOP2zIqIDrbYs5G0uuavg6ay");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("4WthZ3p4lPu6QYonzGHWSPUJzOrCXFOVpvi3tmsCdG7zczlk9O");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("hqzsfacGeuZhTRG1P9GAXO0ZGYDjIwCf");
            state.setStateCodeChar3("hXts7llVN0YQ03NaNPaZ1RhPvaeRLlLH");
            state.setStateDescription("fWbfnvdBXFnN0sJ37BveAPe6HeF8BoOC4aDbCdSoctaJLa84KS");
            state.setStateFlag("ty7VJ2ZAbiEtX41ZGCtfF688nhM5BkZ2UipWNj54mU1tNMyQiL");
            state.setStateName("6myBa6ogBfLJZ7ufCe8xDYqgfPhxKIBgVDgvxibRsj9CRqFeF6");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("9VieSxySOONzT7QCXmJ1GMkzZ9fs6u2t");
            city.setCityDescription("JIPG86KfHsntGcZ4uYJ9iauZ9PUIgZ1xrNbcuZz2XQX6OVcBnZ");
            city.setCityFlag("Ant5Adh1c8EAIQNSyXcA9wSWJqwVmTbrndtgr3NZ4EvApuJbvC");
            city.setCityLatitude(6);
            city.setCityLongitude(0);
            city.setCityName("u4NCqIMZdPwSUbHddTrkfXXCVGBLYE7X1Cku9gxOpAo7UAlFG0");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("97WhjcoosWGBSIn2YS4fBzQEZiE5FGfNALWbSinNjqfeirh0WS");
            address.setAddress2("81tNcSdDuY7CLMPrGQSFjIKCF4cj6om5fcBrL21FGajHS4S3na");
            address.setAddress3("HRuTASBtrbendw7JKXMsJzjohmOzwYEKM1ip8Q391doYN9ncy6");
            address.setAddressLabel("9x4Aikkb84l");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("uuGZ1gmlolrhso5D8qlm6RjtigXHDDq5WR2c5cjEMlLlBib2JL");
            address.setLongitude("aIv4wpLBwgOTIlOsXcaIGZi036z2f7GKXjCbHs5ZvxsRo7356h");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("QVmP2I");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(87);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("9WStQxCvwhjhuF9ZjU9agG1Ystv7aFscCgWvckg3nUO0VJ09W8");
            corecontacts.setFirstName("Vb4TIxhgJ35TB8XkvIJx2tzwt3KhGjgUrn1VxBxR4GwX3FkR82");
            corecontacts.setLastName("vktxlUQykdhXFahAmyeEYkGVvO2CrLVpE47Sz69uXlczReedDk");
            corecontacts.setMiddleName("HQLlqBsGxKqGRgKqbC9kM9kcTvhATbtUvhh956ZR9BoVrlmefO");
            corecontacts.setNativeFirstName("UXMhMDsphU6osBhngMr5LJhWN6dFbaEUSX9tPTwEgDOYYwYrIK");
            corecontacts.setNativeLastName("BTofghpNKzShUlsDuJ3jtq6KAw3av5QSJhPEW2KAlknRaWeR6g");
            corecontacts.setNativeMiddleName("x1yvDBU4LlU9lALciJNvIG4x2kgrANTEeamKGGYdSXcLNoV04g");
            corecontacts.setNativeTitle("ecJllis9vQ1bipI5a1VbgaAb7FMlWcUgTaWbc6PbqgsRuoQwhv");
            corecontacts.setPhoneNumber("t24bdNYu6B4bGeQ5TvF6");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
