/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mailchimpwiremock;

import com.fasterxml.jackson.core.JsonParser;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author intern
 */
public class HttpFetcherTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(18089);

    private HttpFetcher instance;

    @Before
    public void init() {
        instance = new HttpFetcher();
        stubFor(get(urlEqualTo("/folders/list")).willReturn(
                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody("")));
        /**
         *
         * @param jsonString
         * @return
         */
    public static String toGsonFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formatJson = gson.toJson(json);

        return formatJson; //gson
    }



@Test
        public void ok() throws Exception {
        String actual = instance.fetchAsString("https://us10.api.mailchimp.com/2.0/ ");
        String expected = "";
        assertThat(actual, is(expected));
    }

@Test
        public void testPrint()
{
    String compactJson = "{\n" +
"folder_id: 157\n" +
"name: \"NMK\"\n" +
"date_created: \"2015-01-31 11:26:30\"\n" +
"type: \"campaign\"\n" +
"cnt: 1\n" +
"}";
    String formatJson = toGsonFormat(compactJson);

    System.out.println("Compact:\n" + compactJson);
    System.out.println("Json:\n" + formatJson);
} 
}
