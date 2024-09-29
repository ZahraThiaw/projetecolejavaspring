package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.odc.oumar.springproject.Datas.Entity.Note;
import sn.odc.oumar.springproject.Services.Interfaces.NoteService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.NoteControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.NoteDTO;

@RequestMapping("/notes")
@RestController
@Tag(name = "notes", description = "API pour gérer les notes")
public class NoteControllerImpl extends BaseControllerImpl<Note,NoteDTO,Long> implements NoteControllerInterface {

    protected NoteService noteService;

    @Autowired
    // inject the service into the controller constructor  (DI)  : Spring will automatically create an instance of the service and inject it into the controller.
    public NoteControllerImpl(NoteService noteService) {
        super(noteService);
        this.noteService = noteService;
    }

    @Override
    protected Note convertToEntity(NoteDTO noteDTO) {
        return null;
    }

    @Override
    protected NoteDTO convertToDto(Note entity) {
        return null;
    }
}
