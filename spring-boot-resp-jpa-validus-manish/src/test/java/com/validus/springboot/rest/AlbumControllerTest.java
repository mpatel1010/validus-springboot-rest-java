package com.validus.springboot.rest;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.validus.springboot.rest.model.Album;
import com.validus.springboot.rest.service.AlbumService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AlbumControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlbumService albumService;
	
	Album mockAlbum = new Album(1L, "Drones", 2015, new Timestamp(System.currentTimeMillis()), 
			new Timestamp(System.currentTimeMillis()));

	@Test
	public void retrieveAlbum() throws Exception {

		Mockito.when(albumService.retrieveAlbum(Mockito.anyLong())).thenReturn(mockAlbum);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/albums/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{id:1,name:Drones}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

	}

	
	
	
}