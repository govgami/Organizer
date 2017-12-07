package tt.com.tutorial.pcg.organizer.db;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

public class AllPersistenceUnitPostProcessor implements PersistenceUnitPostProcessor
{

   @Autowired
   private ResourcePatternResolver resourceLoader;

   public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo mutablePersistenceUnitInfo)
   {
      try
      {
    	  //XXX
         Resource[] resources = resourceLoader.getResources("tt/com/tutorial/pcg/organizer/db/*.class");
         for (Resource resource : resources)
         {
            CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
            MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(resource);
            if (metadataReader.getAnnotationMetadata().isAnnotated(javax.persistence.Entity.class.getName()))
            {
               mutablePersistenceUnitInfo.addManagedClassName(metadataReader.getClassMetadata().getClassName());
            }
         }
         mutablePersistenceUnitInfo.setExcludeUnlistedClasses(true);
      }
      catch (IOException e)
      {
         throw new RuntimeException(e);
      }
   }
}
