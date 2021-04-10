package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.entities.ForumEntity;
import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.view.ForumViewModel;
import bg.softuni.ITDent.repository.ForumRepository;
import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import bg.softuni.ITDent.service.UserService;
import bg.softuni.ITDent.service.impl.ForumServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumServiceTest {

    private UserEntity testUser;
    private UserEntity testUser1;

    private ForumEntity testForum;
    private ForumEntity testForum1;

    private ForumServiceImpl testService;

    @Mock
    private UserService userService;

    @Mock
    ForumRepository forumRepository;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void init(){

      testUser = new UserEntity();
      testUser.setUsername("user 1");

        testUser1 = new UserEntity();
        testUser1.setUsername("user 2");

      testForum = new ForumEntity();

      testForum.setName("COV_19");
      testForum.setDescription("TEST TEST TEST");
      testForum.setReleaseDate(LocalDate.now());
      testForum.setCreator(testUser);

        testForum1 = new ForumEntity();

        testForum1.setName("COV_191");
        testForum1.setDescription("TEST TEST TEST");
        testForum1.setReleaseDate(LocalDate.now());
        testForum1.setCreator(testUser1);

        testService = new ForumServiceImpl(new ModelMapper(),forumRepository,userService);

    }

    @Test
    public void testFindAll(){

        when(forumRepository.findAll()).thenReturn(List.of(testForum,testForum1));

        List<ForumViewModel> allModels = testService.findAll();

        Assertions.assertEquals(2,allModels.size());

        ForumViewModel forumViewModel = allModels.get(0);
        ForumViewModel forumViewModel1 = allModels.get(1);

        Assertions.assertEquals(testForum.getName(),forumViewModel.getName());
        Assertions.assertEquals(testForum.getCreator().getUsername(),forumViewModel.getCreator());
        Assertions.assertEquals(testForum.getDescription(),forumViewModel.getDescription());

        Assertions.assertEquals(testForum1.getName(),forumViewModel1.getName());
        Assertions.assertEquals(testForum1.getCreator().getUsername(),forumViewModel1.getCreator());
        Assertions.assertEquals(testForum1.getDescription(),forumViewModel1.getDescription());

    }


    @Test
    public void  testNameExist(){
        when(forumRepository.findAll()).thenReturn(List.of(testForum,testForum1));

        List<ForumViewModel>forumEntities = testService.findAll();

        ForumViewModel forumViewModel = forumEntities.get(0);
        ForumViewModel forumViewModel1 = forumEntities.get(1);

        Assertions.assertEquals(testForum.getName(),forumViewModel.getName());
        Assertions.assertEquals(testForum1.getName(),forumViewModel1.getName());

    }

    @Test
    public void testForumCount(){
        when(forumRepository.findAll()).thenReturn(List.of(testForum,testForum1));

        List<ForumViewModel>forumEntities = testService.findAll();

        Assertions.assertEquals(2,forumEntities.size());

    }


}
