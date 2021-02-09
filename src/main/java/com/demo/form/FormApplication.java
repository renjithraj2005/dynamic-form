package com.demo.form;

import com.demo.form.model.Point;
import com.demo.form.model.Node;
import com.demo.form.model.enums.FieldType;
import com.demo.form.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class FormApplication implements CommandLineRunner {

	@Autowired
	NodeRepository nodeRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		Node node1 =  new Node("name", FieldType.TEXT,"what is your name?");
//		Node node2 = new Node("gender",FieldType.OPTION,"what is your gender?");
//		Node node3 = new Node("hobbies",FieldType.MULTI_OPTION,"Select your hobbies?");
//
//		Point point = new Point("userForm");
//		node1.setPoint(point);
//		node2.setPoint(point);
//		node3.setPoint(point);
//		point.getNodes().addAll(Stream.of(node1, node2,node3)
//				.collect(Collectors.toCollection(HashSet::new)));
//
//
//
//		pointRepository.save(point);

//		Point form1 = pointRepository.getOne(1);
//		pointRepository.delete(form1);

		Point point = new Point("Point1");
		Node node =  new Node("name", FieldType.TEXT,"what is your name?");
		node.setPoint(point);
		node = nodeRepository.save(node);


		nodeRepository.delete(node);


	}

}
