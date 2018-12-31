package week7.DigitalMediaLibrary;

import java.util.Objects;

public class MediaEntity implements Comparable<MediaEntity> {
   private ProductType type;
   private String title;
   private int noOfDownloads;

   public ProductType getType () {
      return type;
   }

   public String getTitle () {
      return title;
   }

   public int getNoOfDownloads () {
      return noOfDownloads;
   }

   public MediaEntity ( ProductType type, String title, int noOfDownloads ) {
      this.type = type;
      this.title = title;
      this.noOfDownloads = noOfDownloads;
   }

   public MediaEntity () { }

   @Override
   public boolean equals ( Object o ) {
      if ( this == o ) return true;
      if ( !(o instanceof MediaEntity) ) return false;
      MediaEntity that = (MediaEntity) o;
      return getNoOfDownloads () == that.getNoOfDownloads () &&
              getType () == that.getType () &&
              Objects.equals ( getTitle (), that.getTitle () );
   }

   @Override
   public int hashCode () {
      return Objects.hash ( getType (), getTitle (), getNoOfDownloads () );
   }

   @Override
   public int compareTo ( MediaEntity o ) {
      return this.type.compareTo ( o.type );
   }

   @Override
   public String toString () {
      return "MediaEntity{" +
              "type=" + type +
              ", title='" + title + '\'' +
              ", noOfDownloads=" + noOfDownloads +
              '}';
   }
}
