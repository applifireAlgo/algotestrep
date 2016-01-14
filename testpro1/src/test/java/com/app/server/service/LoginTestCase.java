package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(62);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("4VIoMor77l8h2BSAjNo8W7tkg2OZWGVHTpkX6pFHjw8CdqiOV9");
            corecontacts.setFirstName("qDe3GkaPnYivXqzMYhpfnkayWCJmXzm4NRuZH7BeibdZ6gLpp7");
            Gender gender = new Gender();
            gender.setGender("prnUnZ4p4LqjZjyhqviQ0uQwh3eKVLmkKW4lt73LgM7RwyfxFs");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("7M");
            language.setAlpha3("CkU");
            language.setAlpha4("A29z");
            language.setAlpha4parentid(5);
            language.setLanguage("zf8PH0plPw1P09dRpC6YS4Yh7xEHZnmY3YyyK6Ea1yTRPSi9YF");
            language.setLanguageDescription("BV182e0LmOOGpy0NlpzH5QnXWtLgWlTeCC92shPvqidTvkhJIK");
            language.setLanguageIcon("lLrysFPhwMQe15GPySIETWvTrlL6IVuSzeQ36dP3vAKXsGlZdI");
            language.setLanguageType("75XxXBKXRzDuWi9chEyaxp2yq5qz9FGf");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("LFRR8tU5e7KBC50HGmRMGuofHHdeyzBHVQCS1T6QfN0wzVdzC6");
            timezone.setCountry("hWCC4S01z8n80r2jWEIlbtCFhlyyY8HMJoFUtFzV99Hj9UqgsI");
            timezone.setGmtLabel("ZioHgGSvhWnZdBnBWwoacpYn1ggQSUjcwhPbILYu7uP5megR2h");
            timezone.setTimeZoneLabel("amrOIM1SocfSRlivWn2I2MCEIhJZi1ZE7vi1K6JF58UdM6txZx");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("XaHfmMa2zdFaft8g2SGLnPRqTXHUhuGujUM6CUauabujtLEetK");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("gfBuIebDWnVbX3FTgAj1YZsWVOwo6Ot4uNjRoSNakQgp96YiC8");
            corecontacts.setFirstName("z40TpvkBg5wxeCRPF3qUhIde71fafXdxmQGje3BHkfw9mGIWDy");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("OWNhNsTCcj6OhuDbRGBwzHq0rCiOREiH4VkqLHD8Y9Xta85gW6");
            corecontacts.setMiddleName("3Tmbh5ZVX5JHsQzeLJqtdFXrvQnJewltUvkBDaQXYuG2ONYzvV");
            corecontacts.setNativeFirstName("MenEiyE2kh8WWhTWJvHltDBAnu2H9cZYtyKRYlucxMmoLpqfw4");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("TCz4XusOH1XuXOBYU2Li2JaHW1DQR9pWt612oKSSrwh42OOu39");
            corecontacts.setNativeMiddleName("HOR17QApJvfHDecWdW5sgxhaLBV4Wo8ceRD1lqUsIedwRvCYn0");
            corecontacts.setNativeTitle("Lih7Xdb5jwQLVtjYG6pXi9nJgFrXHapTHy4Jt8eimvibredZbc");
            corecontacts.setPhoneNumber("IKKfZRx4PShcoyKaHYP3");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Vveis0A9HrEnHiqK5bCCoPOf1DUqmMiuTatdI3PWubVLV0u0eG");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1834);
            user.setUserAccessCode(5);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("yZvU24o1Q8weLzTcimkStR0qbH36Rk8aLPHQczfU9dTivsScqe");
            useraccessdomain.setDomainHelp("gMd7xt2IaCViWhvz2du9N3xKnw56nQI0UmbwAYFtipmfMGJxb0");
            useraccessdomain.setDomainIcon("KiU0sU4aneeXPsBwJKrMOEf57axGvSIgY6Ywgdxc3cetzlHm45");
            useraccessdomain.setDomainName("6477H5K6N172OUL1C2WaF580Z2Yo09IfCHEVdX1Oono6Z8dQlj");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("Qg5pDLVNue5NrjpdYPBlPCxn97Lt3NTqtFbMQZh3TtHycXqfxE");
            useraccesslevel.setLevelHelp("vPdECReCVBvqp8E8VnPmBQ14f821FMSZOH0konYSmGBCsBtuaV");
            useraccesslevel.setLevelIcon("V3kD1aX7nMGOYaEyda2lJnj9CtswjQbOBGpvQB4RbGoApawyNz");
            useraccesslevel.setLevelName("mkpJTYVpCO2cpx1vi53qUzC27GTO21gSQcILU2CgAmlWFCHCpk");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("6zJgkeoTYJT44BJ5bb9qI6TNetZyL6hmBYSgfoRa9GdJsNNBow");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(895);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(9);
            login.setIsAuthenticated(true);
            login.setLoginId("zQAl1gQrjWXp4UeMwzEdmgE9NE1RTV0aNhJhFjyS1SWeFir1sN");
            login.setServerAuthImage("P5p13aNQFsmqIMHKq7E719cjuPY91SxW");
            login.setServerAuthText("CAhDZLrLhUrXbJvT");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(9);
            login.setLoginId("WmJx3skdDqV732cAv680J13VBN53iZ0zhwidpUon40XCObcDdp");
            login.setServerAuthImage("WL1flt4BzjAtBQhmH7EaBEodXppvi49P");
            login.setServerAuthText("dSeNvzG88qDNqmKK");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
