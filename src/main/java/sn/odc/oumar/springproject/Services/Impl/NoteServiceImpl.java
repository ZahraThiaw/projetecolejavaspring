package sn.odc.oumar.springproject.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Entity.Note;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.NoteRepository;
import sn.odc.oumar.springproject.Services.Interfaces.NoteService;

@Service
public class NoteServiceImpl extends BaseServiceImpl<Note,Long> implements NoteService {
    protected NoteRepository noteRepository;
    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        super(noteRepository);
        this.noteRepository = noteRepository;
    }
}
