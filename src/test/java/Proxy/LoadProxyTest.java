package Proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LoadProxyTest {

    @BeforeEach
    void setUp() {
        BD.addLoad(new Load(1, "Furniture", "Juiz de Fora", "Rio de Janeiro", 40000.0f));
        BD.addLoad(new Load(2, "Appliances", "Vitória", "Maringá", 67500.0f));
    }

    @Test
    void shouldReturnLoadData() {
        LoadProxy load = new LoadProxy(1);

        assertEquals(Arrays.asList("Furniture", "Juiz de Fora", "Rio de Janeiro"), load.getLoadData());
    }

    @Test
    void shouldReturnTotalLoadValue() {
        Employee employee = new Employee("John Wick", true);
        LoadProxy load = new LoadProxy(2);

        assertEquals(67500.0f, load.getLoadValue(employee));
    }

    @Test
    void shouldThrowUnauthorizedExceptionForNonAdminEmployeeAccessingTotalLoadValue() {
        try {
            Employee employee = new Employee("John Strong", false);
            LoadProxy load = new LoadProxy(2);

            load.getLoadValue(employee);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Employee not authorized.", e.getMessage());
        }
    }

}
