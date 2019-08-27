package com.example.demo1.POJO.Redispojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/*** imports ***/
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 7760614561073458247L;
	private Long id;
	private String userName;
	private String note;

}