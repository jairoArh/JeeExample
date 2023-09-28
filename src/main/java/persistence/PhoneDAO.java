package persistence;

import com.example.demoprog3.logic.Phone;

import java.util.List;

public class PhoneDAO implements InterfaceDAO<Phone>{
    @Override
    public List<Phone> findAll() {
        return null;
    }

    @Override
    public Phone findById(Integer id) {
        return null;
    }

    @Override
    public boolean add(Phone object) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Phone update(Phone object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
