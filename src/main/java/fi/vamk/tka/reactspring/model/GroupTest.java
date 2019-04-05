package fi.vamk.tka.reactspring.model;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.Test;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackageClasses = GroupRepository.class)

public class GroupTest{
    @Autowired
    private GroupRepository Repository;
    @Test
    public void justTesting(){
        System.out.println("------test,test,test------");
    }
    
    @Test
    public void againTesting(){
        System.out.println("------Jer,Jer,Jer------");
    }

    @Test
    public void addGroupAndVerifyTest(){
        //create an instance of Group
        Group item = new Group();

        //set the group name to "Vaasa JUG"
        item.setName("Vaasa JUG");
        //add instance of GroupRepository to save it to database
        Repository.save(item);
        Group found = Repository.findByName("Vaasa2 JUG");
        assertNotNull(found);
        if(found != null){
            assertEqual(found.getName(),item.getName());
            repository.delete(found); //dont want to keep these data
        }
        

        //get the save one by findByName

        //compare the initial and the saved one if the game is the same
        //use assertEquals

    }
}