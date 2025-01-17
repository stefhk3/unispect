package ee.ut.cs.unispect.om;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * This class was autogenerated by Torque on:
 *
 * [Fri Jan 17 19:55:56 EET 2025]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to UnispectSpectrumType
 */
public abstract class BaseUnispectSpectrumType extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1737136556691L;

    /** The Peer class */
    private static final UnispectSpectrumTypePeer peer =
        new UnispectSpectrumTypePeer();


    /** The value for the spectrumTypeId field */
    private int spectrumTypeId;

    /** The value for the name field */
    private String name;

    /** The value for the ontologyLink field */
    private String ontologyLink;

    /** The value for the ontologyTerm field */
    private String ontologyTerm;


    /**
     * Get the SpectrumTypeId
     *
     * @return int
     */
    public int getSpectrumTypeId()
    {
        return spectrumTypeId;
    }


    /**
     * Set the value of SpectrumTypeId
     *
     * @param v new value
     */
    public void setSpectrumTypeId(int v) throws TorqueException
    {

        if (this.spectrumTypeId != v)
        {
            this.spectrumTypeId = v;
            setModified(true);
        }



        // update associated UnispectSpectrum
        if (collUnispectSpectrums != null)
        {
            for (int i = 0; i < collUnispectSpectrums.size(); i++)
            {
                ((UnispectSpectrum) collUnispectSpectrums.get(i))
                        .setSpectrumTypeId(v);
            }
        }
    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v) 
    {

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

    /**
     * Get the OntologyLink
     *
     * @return String
     */
    public String getOntologyLink()
    {
        return ontologyLink;
    }


    /**
     * Set the value of OntologyLink
     *
     * @param v new value
     */
    public void setOntologyLink(String v) 
    {

        if (!ObjectUtils.equals(this.ontologyLink, v))
        {
            this.ontologyLink = v;
            setModified(true);
        }


    }

    /**
     * Get the OntologyTerm
     *
     * @return String
     */
    public String getOntologyTerm()
    {
        return ontologyTerm;
    }


    /**
     * Set the value of OntologyTerm
     *
     * @param v new value
     */
    public void setOntologyTerm(String v) 
    {

        if (!ObjectUtils.equals(this.ontologyTerm, v))
        {
            this.ontologyTerm = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collUnispectSpectrums
     */
    protected List<UnispectSpectrum> collUnispectSpectrums;

    /**
     * Temporary storage of collUnispectSpectrums to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initUnispectSpectrums()
    {
        if (collUnispectSpectrums == null)
        {
            collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
        }
    }


    /**
     * Method called to associate a UnispectSpectrum object to this object
     * through the UnispectSpectrum foreign key attribute
     *
     * @param l UnispectSpectrum
     * @throws TorqueException
     */
    public void addUnispectSpectrum(UnispectSpectrum l) throws TorqueException
    {
        getUnispectSpectrums().add(l);
        l.setUnispectSpectrumType((UnispectSpectrumType) this);
    }

    /**
     * Method called to associate a UnispectSpectrum object to this object
     * through the UnispectSpectrum foreign key attribute using connection.
     *
     * @param l UnispectSpectrum
     * @throws TorqueException
     */
    public void addUnispectSpectrum(UnispectSpectrum l, Connection con) throws TorqueException
    {
        getUnispectSpectrums(con).add(l);
        l.setUnispectSpectrumType((UnispectSpectrumType) this);
    }

    /**
     * The criteria used to select the current contents of collUnispectSpectrums
     */
    private Criteria lastUnispectSpectrumsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUnispectSpectrums(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<UnispectSpectrum> getUnispectSpectrums()
        throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            collUnispectSpectrums = getUnispectSpectrums(new Criteria(10));
        }
        return collUnispectSpectrums;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UnispectSpectrumType has previously
     * been saved, it will retrieve related UnispectSpectrums from storage.
     * If this UnispectSpectrumType is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<UnispectSpectrum> getUnispectSpectrums(Criteria criteria) throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            if (isNew())
            {
               collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
            }
            else
            {
                criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId() );
                collUnispectSpectrums = UnispectSpectrumPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                if (!lastUnispectSpectrumsCriteria.equals(criteria))
                {
                    collUnispectSpectrums = UnispectSpectrumPeer.doSelect(criteria);
                }
            }
        }
        lastUnispectSpectrumsCriteria = criteria;

        return collUnispectSpectrums;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getUnispectSpectrums(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<UnispectSpectrum> getUnispectSpectrums(Connection con) throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            collUnispectSpectrums = getUnispectSpectrums(new Criteria(10), con);
        }
        return collUnispectSpectrums;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UnispectSpectrumType has previously
     * been saved, it will retrieve related UnispectSpectrums from storage.
     * If this UnispectSpectrumType is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<UnispectSpectrum> getUnispectSpectrums(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            if (isNew())
            {
               collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
            }
            else
            {
                 criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                 collUnispectSpectrums = UnispectSpectrumPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                 if (!lastUnispectSpectrumsCriteria.equals(criteria))
                 {
                     collUnispectSpectrums = UnispectSpectrumPeer.doSelect(criteria, con);
                 }
             }
         }
         lastUnispectSpectrumsCriteria = criteria;

         return collUnispectSpectrums;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UnispectSpectrumType is new, it will return
     * an empty collection; or if this UnispectSpectrumType has previously
     * been saved, it will retrieve related UnispectSpectrums from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UnispectSpectrumType.
     */
    protected List<UnispectSpectrum> getUnispectSpectrumsJoinUnispectSpectrumType(Criteria criteria)
        throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            if (isNew())
            {
               collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
            }
            else
            {
                criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectSpectrumType(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
            if (!lastUnispectSpectrumsCriteria.equals(criteria))
            {
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectSpectrumType(criteria);
            }
        }
        lastUnispectSpectrumsCriteria = criteria;

        return collUnispectSpectrums;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UnispectSpectrumType is new, it will return
     * an empty collection; or if this UnispectSpectrumType has previously
     * been saved, it will retrieve related UnispectSpectrums from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UnispectSpectrumType.
     */
    protected List<UnispectSpectrum> getUnispectSpectrumsJoinUnispectCompound(Criteria criteria)
        throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            if (isNew())
            {
               collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
            }
            else
            {
                criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectCompound(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
            if (!lastUnispectSpectrumsCriteria.equals(criteria))
            {
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectCompound(criteria);
            }
        }
        lastUnispectSpectrumsCriteria = criteria;

        return collUnispectSpectrums;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this UnispectSpectrumType is new, it will return
     * an empty collection; or if this UnispectSpectrumType has previously
     * been saved, it will retrieve related UnispectSpectrums from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in UnispectSpectrumType.
     */
    protected List<UnispectSpectrum> getUnispectSpectrumsJoinUnispectSource(Criteria criteria)
        throws TorqueException
    {
        if (collUnispectSpectrums == null)
        {
            if (isNew())
            {
               collUnispectSpectrums = new ArrayList<UnispectSpectrum>();
            }
            else
            {
                criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectSource(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(UnispectSpectrumPeer.SPECTRUM_TYPE_ID, getSpectrumTypeId());
            if (!lastUnispectSpectrumsCriteria.equals(criteria))
            {
                collUnispectSpectrums = UnispectSpectrumPeer.doSelectJoinUnispectSource(criteria);
            }
        }
        lastUnispectSpectrumsCriteria = criteria;

        return collUnispectSpectrums;
    }



        
    private static List<String> fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List<String> getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList<String>();
            fieldNames.add("SpectrumTypeId");
            fieldNames.add("Name");
            fieldNames.add("OntologyLink");
            fieldNames.add("OntologyTerm");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("SpectrumTypeId"))
        {
            return new Integer(getSpectrumTypeId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("OntologyLink"))
        {
            return getOntologyLink();
        }
        if (name.equals("OntologyTerm"))
        {
            return getOntologyTerm();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("SpectrumTypeId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSpectrumTypeId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        if (name.equals("OntologyLink"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOntologyLink((String) value);
            return true;
        }
        if (name.equals("OntologyTerm"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOntologyTerm((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(UnispectSpectrumTypePeer.SPECTRUM_TYPE_ID))
        {
            return new Integer(getSpectrumTypeId());
        }
        if (name.equals(UnispectSpectrumTypePeer.NAME))
        {
            return getName();
        }
        if (name.equals(UnispectSpectrumTypePeer.ONTOLOGY_LINK))
        {
            return getOntologyLink();
        }
        if (name.equals(UnispectSpectrumTypePeer.ONTOLOGY_TERM))
        {
            return getOntologyTerm();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (UnispectSpectrumTypePeer.SPECTRUM_TYPE_ID.equals(name))
        {
            return setByName("SpectrumTypeId", value);
        }
      if (UnispectSpectrumTypePeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (UnispectSpectrumTypePeer.ONTOLOGY_LINK.equals(name))
        {
            return setByName("OntologyLink", value);
        }
      if (UnispectSpectrumTypePeer.ONTOLOGY_TERM.equals(name))
        {
            return setByName("OntologyTerm", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getSpectrumTypeId());
        }
        if (pos == 1)
        {
            return getName();
        }
        if (pos == 2)
        {
            return getOntologyLink();
        }
        if (pos == 3)
        {
            return getOntologyTerm();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("SpectrumTypeId", value);
        }
    if (position == 1)
        {
            return setByName("Name", value);
        }
    if (position == 2)
        {
            return setByName("OntologyLink", value);
        }
    if (position == 3)
        {
            return setByName("OntologyTerm", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(UnispectSpectrumTypePeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    UnispectSpectrumTypePeer.doInsert((UnispectSpectrumType) this, con);
                    setNew(false);
                }
                else
                {
                    UnispectSpectrumTypePeer.doUpdate((UnispectSpectrumType) this, con);
                }
            }


            if (collUnispectSpectrums != null)
            {
                for (int i = 0; i < collUnispectSpectrums.size(); i++)
                {
                    ((UnispectSpectrum) collUnispectSpectrums.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key spectrumTypeId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setSpectrumTypeId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setSpectrumTypeId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getSpectrumTypeId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public UnispectSpectrumType copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public UnispectSpectrumType copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public UnispectSpectrumType copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new UnispectSpectrumType(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public UnispectSpectrumType copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new UnispectSpectrumType(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected UnispectSpectrumType copyInto(UnispectSpectrumType copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected UnispectSpectrumType copyInto(UnispectSpectrumType copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected UnispectSpectrumType copyInto(UnispectSpectrumType copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setSpectrumTypeId(spectrumTypeId);
        copyObj.setName(name);
        copyObj.setOntologyLink(ontologyLink);
        copyObj.setOntologyTerm(ontologyTerm);

        copyObj.setSpectrumTypeId( 0);

        if (deepcopy)
        {


        List<UnispectSpectrum> vUnispectSpectrums = getUnispectSpectrums();
        if (vUnispectSpectrums != null)
        {
            for (int i = 0; i < vUnispectSpectrums.size(); i++)
            {
                UnispectSpectrum obj =  vUnispectSpectrums.get(i);
                copyObj.addUnispectSpectrum(obj.copy());
            }
        }
        else
        {
            copyObj.collUnispectSpectrums = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected UnispectSpectrumType copyInto(UnispectSpectrumType copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setSpectrumTypeId(spectrumTypeId);
        copyObj.setName(name);
        copyObj.setOntologyLink(ontologyLink);
        copyObj.setOntologyTerm(ontologyTerm);

        copyObj.setSpectrumTypeId( 0);

        if (deepcopy)
        {


        List<UnispectSpectrum> vUnispectSpectrums = getUnispectSpectrums(con);
        if (vUnispectSpectrums != null)
        {
            for (int i = 0; i < vUnispectSpectrums.size(); i++)
            {
                UnispectSpectrum obj =  vUnispectSpectrums.get(i);
                copyObj.addUnispectSpectrum(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collUnispectSpectrums = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public UnispectSpectrumTypePeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return UnispectSpectrumTypePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("UnispectSpectrumType:\n");
        str.append("SpectrumTypeId = ")
           .append(getSpectrumTypeId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("OntologyLink = ")
           .append(getOntologyLink())
           .append("\n");
        str.append("OntologyTerm = ")
           .append(getOntologyTerm())
           .append("\n");
        return(str.toString());
    }
}
