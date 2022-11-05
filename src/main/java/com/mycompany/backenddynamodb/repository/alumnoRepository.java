package com.mycompany.backenddynamodb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.mycompany.backenddynamodb.entity.alumno;

@Repository
public class alumnoRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public alumno save(alumno person){
        dynamoDBMapper.save(person);
        return person;
    }

    public alumno findById(String id){
       return dynamoDBMapper.load(alumno.class, id);
    }

    public List<alumno> findAll(){
        return dynamoDBMapper.scan(alumno.class, new DynamoDBScanExpression());
    }

    public String update(String id, alumno person){
        dynamoDBMapper.save(person,
                new DynamoDBSaveExpression()
        .withExpectedEntry("idAlumno",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(id)
                )));
        return id;
    }

    public String delete(String id){
        alumno person = dynamoDBMapper.load(alumno.class, id);
        dynamoDBMapper.delete(person);
        return "Person deleted successfully:: "+id;
    }
    
}
