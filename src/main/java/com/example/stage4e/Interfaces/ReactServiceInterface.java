package com.example.stage4e.Interfaces;

import com.example.stage4e.Entities.React;

import java.util.List;

public interface ReactServiceInterface {
    public String DeleteReact (Integer idReact);
    public React addReact(React react, Integer idUsr , Integer idPost ) ;

    public List<React> getPostReacts (Integer idPost);

    public React updateReact(React react , Integer Idreact);
}
