package com.scrap.bcp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scrap.bcp.api.dto.CreateResultDTO;
import com.scrap.bcp.api.dto.ResultDTO;

import com.scrap.bcp.api.dto.input.CreateExchangeRateDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles(profiles = "test")
@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deberia poder aplicar el tipo de cambio del dia")
    public void shouldApplyCurrencyValueIncrement() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("amount", "20.00")
                .param("sourceCurrency", "USD")
                .param("targetCurrency", "PEN")
                .contentType(MediaType.APPLICATION_JSON))

                .andReturn();

        MvcResult mvcResultAsync = mvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andReturn();


        ResultDTO resultDTO = objectMapper
                .readValue(mvcResultAsync.getResponse().getContentAsByteArray(), ResultDTO.class);

        Assertions.assertEquals("102.6000", resultDTO.getExchangeRateAmount().toString());
        Assertions.assertEquals(5.13, resultDTO.getExchangeRate().doubleValue());
    }


    @Test
    @DisplayName("Deberia poder guardar el tipo de cambio actual")
    public void shouldSaveNewExchangeRate() throws Exception {
        CreateExchangeRateDTO createExchangeRateDTO = new CreateExchangeRateDTO();
        createExchangeRateDTO.setValue(4.25);
        createExchangeRateDTO.setSourceCurrency("USD");
        createExchangeRateDTO.setTargetCurrency("PEN");
        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/exchange-rates")
                .content(objectMapper.writeValueAsString(createExchangeRateDTO))
                .contentType(MediaType.APPLICATION_JSON))

                .andReturn();

        MvcResult mvcResultAsync = mvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andReturn();


        CreateResultDTO resultDTO = objectMapper
                .readValue(mvcResultAsync.getResponse().getContentAsByteArray(), CreateResultDTO.class);

        Assertions.assertEquals("4.25", resultDTO.getExchangeRate().toString());
        Assertions.assertEquals("USD", resultDTO.getSourceCurrency());
    }


}
