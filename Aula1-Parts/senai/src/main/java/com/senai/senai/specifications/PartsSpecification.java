package com.senai.senai.specifications;

import com.senai.senai.models.Parts;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class PartsSpecification {

    @And({
            //path = atributo do banco
            //params = o parametro q vem do front/insomnia
            //spec = a logica que sera efetuada na busca
            @Spec(path = "type", params = "type", spec = EqualIgnoreCase.class),
            @Spec(path = "cost", params = "cost.max", spec = LessThanOrEqual.class),
            @Spec(path = "cost", params = "cost.min", spec = GreaterThanOrEqual.class),
            @Spec(path = "title", params = "title", spec = LikeIgnoreCase.class),
            @Spec(path = "createdDate", params = {"after","before"}, spec = Between.class),
    })
    public static interface PartsSpec extends Specification<Parts> {}
}
