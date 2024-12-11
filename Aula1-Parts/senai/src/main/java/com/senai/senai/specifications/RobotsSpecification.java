package com.senai.senai.specifications;

import com.senai.senai.models.Robots;
import net.kaczmarzyk.spring.data.jpa.domain.EqualIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class RobotsSpecification {

    @And({
            @Spec(path = "HANDLEBAR.title", params = "HANDLEBARTitle", spec = LikeIgnoreCase.class),
            @Spec(path = "base.title", params = "baseTitle", spec = LikeIgnoreCase.class),
            @Spec(path = "REARWHEEL.title", params = "REARWHEELTitle", spec = LikeIgnoreCase.class),
            @Spec(path = "WHEEL.title", params = "WHEELTitle", spec = LikeIgnoreCase.class),
            @Spec(path = "ENGINE.title", params = "ENGINETitle", spec = LikeIgnoreCase.class),

            @Spec(path = "HANDLEBAR.type", params = "HANDLEBARType", spec = EqualIgnoreCase.class),
            @Spec(path = "base.type", params = "baseType", spec = EqualIgnoreCase.class),
            @Spec(path = "REARWHEEL.type", params = "REARWHEELType", spec = EqualIgnoreCase.class),
            @Spec(path = "WHEEL.type", params = "WHEELType", spec = EqualIgnoreCase.class),
            @Spec(path = "ENGINE.type", params = "ENGINEType", spec = EqualIgnoreCase.class),

            @Spec(path = "HANDLEBAR.id", params = "HANDLEBARId", spec = EqualIgnoreCase.class),
            @Spec(path = "base.id", params = "baseId", spec = EqualIgnoreCase.class),
            @Spec(path = "REARWHEEL.id", params = "REARWHEELId", spec = EqualIgnoreCase.class),
            @Spec(path = "WHEEL.id", params = "WHEELId", spec = EqualIgnoreCase.class),
            @Spec(path = "ENGINE.id", params = "ENGINEId", spec = EqualIgnoreCase.class),

    })
    public interface RobotsSpec extends Specification<Robots> {}
}
