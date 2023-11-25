package dev.neordinary.zero.service;

import dev.neordinary.zero.converter.NoteConverter;
import dev.neordinary.zero.domain.NoteEntity;
import dev.neordinary.zero.domain.NoteRepository;
import dev.neordinary.zero.domain.UserEntity;
import dev.neordinary.zero.domain.UserRepository;
import dev.neordinary.zero.dto.NoteRequest;
import dev.neordinary.zero.dto.NoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteResponse.NoteJoinRes createNote(Long userId, NoteRequest.NoteJoin noteJoin) {
        UserEntity currentUser = userRepository.findById(userId).orElseThrow(() -> null);
        NoteEntity newNote = NoteConverter.toNote(noteJoin, currentUser);
        return NoteConverter.toNoteDto(noteRepository.save(newNote));
    }

    public NoteResponse.NoteJoinRes getNote(Long userId) {

        return null;
    }
}
