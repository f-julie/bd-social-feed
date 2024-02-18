package com.bloomtech.socialfeed;

import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.observerpattern.SourceFeed;
import com.bloomtech.socialfeed.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MT04_LocalDateTime {
    PostRepository postRepository = new PostRepository();

    @BeforeEach
    public void init() {
        SeedData.run();
    }

    @Test
    public void assertThat_PostPostedonIsTypeLocalDateTime() throws NoSuchFieldException {
        assertEquals(LocalDateTime.class, Post.class.getDeclaredField("postedon").getType());
    }

    @Test
    public void assertThat_newPostsHaveCurrentDate() throws NoSuchFieldException {
        SourceFeed sourceFeed = new SourceFeed();
        User user = new User();
            user.setUsername("Testuser");
        Post post = sourceFeed.addPost(user, "test post");
        fail("ACTION REQUIRED: When you've updated the `postedon` field to the correct data type, go into " + new Throwable().getStackTrace()[0].getFileName() + "'s " + new Throwable().getStackTrace()[0].getMethodName() + " method to uncomment the assertEquals line and remove this line"); //Uncomment line below and ensure it passes before submitting to CodeGrade
//        assertEquals(LocalDateTime.now().getDayOfYear(), post.getPostedon().getDayOfYear());
    }
}
