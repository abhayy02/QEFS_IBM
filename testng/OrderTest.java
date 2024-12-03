import org.testng.annotations.*;

import java.sql.SQLOutput;

public class OrderTest {
    @BeforeSuite
        void beforeSuite(){
        System.out.println("Before Suite Fired");
    }
    @BeforeClass
        void beforeClass(){
        System.out.println("Before Class Fired");
    }
    @BeforeTest
        void beforeTest(){
        System.out.println("Before Test Fired");
    }
    @BeforeMethod
        void beforeMethod(){
        System.out.println("Before Method Fired");
    }
    @AfterMethod
        void afterMethod(){
        System.out.println("After Method Fired");
    }
    @AfterTest
        void afterTest(){
        System.out.println("After Test Fired");
    }
    @AfterClass
        void afterClass(){
        System.out.println("After Class fired");
    }
    @AfterSuite
        void afterSuite(){
        System.out.println("After Suite Fired");
    }
    @Test
        void Test1(){
        System.out.println("Test 1 Fired");
    }
    @Test
        void Test2(){
        System.out.println("Test 2 Fired");
    }
}
