package com.example.demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SbpApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);
		
		try (Connection conn = ds.getConnection() ) {
			System.out.println("Cooooooon="+conn);
			assertThat(conn).isInstanceOf(Connection.class);
			assertEquals(100, getLong(conn, "select 100"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stat = conn.createStatement()) {
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				result = rs.getLong(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Test
	void contextLoads() {
	}

}
