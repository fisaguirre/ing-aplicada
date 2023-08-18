package com.sgaraba.library.domain;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.sgaraba.library.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Client.class);
        Client client1 = new Client();
        client1.setId(1L);
        Client client2 = new Client();
        client2.setId(client1.getId());
        assertThat(client1).isEqualTo(client2);
        client2.setId(2L);
        assertThat(client1).isNotEqualTo(client2);
        client1.setId(null);
        assertThat(client1).isNotEqualTo(client2);
    }

    //Crear un cliente
    @Test
    public void testCreateCliente() {
        Client cliente1 = new Client();
        cliente1.setFirstName("Agustin");
        cliente1.setLastName("Fernandez");
        cliente1.setEmail("agustin@gmail.com");
        cliente1.setAddress("Paso de los andes 1495");
        cliente1.setPhone("2615435642");
        String phone = "2615435642";

        assertNotNull(cliente1);
        assertEquals(phone, cliente1.getPhone());
    } 
}
