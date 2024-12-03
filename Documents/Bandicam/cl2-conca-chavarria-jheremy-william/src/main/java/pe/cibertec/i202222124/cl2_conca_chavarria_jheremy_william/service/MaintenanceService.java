package pe.cibertec.i202222124.cl2_conca_chavarria_jheremy_william.service;


import pe.cibertec.i202222124.cl2_conca_chavarria_jheremy_william.dto.FilmDetailDto;
import pe.cibertec.i202222124.cl2_conca_chavarria_jheremy_william.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> getAllFilms();

    FilmDetailDto getFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(int id);

    FilmDetailDto createFilm(FilmDetailDto filmDetailDto);


}