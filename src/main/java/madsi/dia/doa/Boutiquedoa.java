package madsi.dia.doa;

import madsi.dia.model.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Boutiquedoa extends JpaRepository<Boutique,Integer>{
    Boutique findById(int id);

}
