package com.example.systemcouse.database;

import com.example.systemcouse.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseManagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        for(int i=1; i<10; i++) {
            Task task = new Task();
            task.setTaskName(i + " Site's task ");

            entityManager.persist(task);
        }

        List<Rank> ranks = new ArrayList<>();
        for(int i=1; i<10; i++) {
            Rank rank = new Rank();
            rank.setRankName(i + " Rank name");
            ranks.add(rank);
            entityManager.persist(rank);
        }

        List<User_> userList = new ArrayList<>();
        for(int i=0; i<ranks.size(); i++) {
            User_ user = new User_();
            user.setUserName((i + 1) + " User");
            user.setRank(ranks.get(i));
            user.setLastSession(LocalDate.of(2021, 10, i+20));
            userList.add(user);
            entityManager.persist(user);
        }

        List<Tutor> tutors = new ArrayList<>();
        for(int i=0; i<userList.size(); i++) {
            Tutor tutor = new Tutor();
            tutor.setTutorName((i + 1) + " Teacher name");
            tutor.setSpecialization((i + 1) + " Specialization Name ");
            tutor.setDescription((i + 1) + " Description ");
            tutors.add(tutor);
            entityManager.persist(tutor);
        }
        for(int i=0; i<userList.size(); i++) {
            Quality quality = new Quality();
            quality.setQualityName((i + 1) + " Ability Name ");
            quality.setTutor(tutors.get(i));
            entityManager.persist(quality);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
