package chatSocketsGrupoC;

/**
   Una clase que representa a un usuario del chat room.
*/
public class Chatter
{  
   /**
      Construye un Chatter con un nombre dado.
   */
   public Chatter(String aName) 
   {
      name = aName;
   }

   /**
      Retorna el nombre.
      @return el nombre
   */
   public String getName()
   {
      return name;
   }

   String name;
}