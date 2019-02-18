package br.com.joaoaraujo.jsfprimefaces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.joaoaraujo.jsfprimefaces.entity.ItemEntity;
import br.com.joaoaraujo.jsfprimefaces.repository.ItemRepository;

@FacesConverter(value="itemConverter")
public class ItemConverter implements Converter {

 @Override
 public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
	 int id = Integer.parseInt(string.split("-")[0].trim());
	 ItemRepository itemRepository = new ItemRepository();
	 ItemEntity item = itemRepository.findById(id);
	 return item;
 }

 @Override
 public String getAsString(FacesContext fc, UIComponent uic, Object o) {
	 ItemEntity item = new ItemEntity();
	 item = (ItemEntity) o;
	 return String.valueOf(item.getId()).concat(" - ").concat(item.getDescricao());
 }

}
