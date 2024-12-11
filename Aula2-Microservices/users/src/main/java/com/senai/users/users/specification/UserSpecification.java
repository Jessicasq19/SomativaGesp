package com.senai.users.users.specification;

import com.senai.users.users.models.User;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    @And({
            @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
            @Spec(path = "cpf", params = "cpf", spec = Equal.class),
            @Spec(path = "phone", params = "phone", spec = LikeIgnoreCase.class),
            @Spec(path = "birthday", params = {"birthdayStart","birthdayEnd"}, spec = Between.class),
            @Spec(path = "createdDate", params = {"createdDateStart","createdDateEnd"}, spec = Between.class),
    })
    public interface UserSpec extends Specification<User> {}
}
