package learn.generate;

public interface IService<DTO> {
	 boolean insert(DTO dto);
	 boolean update(DTO dto);
}



