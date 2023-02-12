package cn.ekgc.phenix.system.dictionary.util;

import cn.ekgc.phenix.system.dictionary.pojo.entity.Dictionary;
import cn.ekgc.phenix.system.dictionary.pojo.vo.DictionaryVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T21:50:30+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
public class DictionaryPojoUtilImpl implements DictionaryPojoUtil {

    @Override
    public Dictionary parseVOToEntity(DictionaryVO queryVO) {
        if ( queryVO == null ) {
            return null;
        }

        Dictionary dictionary = new Dictionary();

        dictionary.setParent( queryVOParentVOId( queryVO ) );
        dictionary.setStatus( queryVO.getStatus() );
        dictionary.setCreatedTime( queryVO.getCreatedTime() );
        dictionary.setModifiedTime( queryVO.getModifiedTime() );
        dictionary.setId( queryVO.getId() );
        dictionary.setCode( queryVO.getCode() );
        dictionary.setText( queryVO.getText() );

        return dictionary;
    }

    @Override
    public DictionaryVO parseEntityToVO(Dictionary query) {
        if ( query == null ) {
            return null;
        }

        DictionaryVO dictionaryVO = new DictionaryVO();

        dictionaryVO.setParentVO( dictionaryToDictionaryVO( query ) );
        dictionaryVO.setStatus( query.getStatus() );
        dictionaryVO.setCreatedTime( query.getCreatedTime() );
        dictionaryVO.setModifiedTime( query.getModifiedTime() );
        dictionaryVO.setId( query.getId() );
        dictionaryVO.setCode( query.getCode() );
        dictionaryVO.setText( query.getText() );

        return dictionaryVO;
    }

    @Override
    public List<DictionaryVO> list(List<Dictionary> queryList) {
        if ( queryList == null ) {
            return null;
        }

        List<DictionaryVO> list = new ArrayList<DictionaryVO>( queryList.size() );
        for ( Dictionary dictionary : queryList ) {
            list.add( parseEntityToVO( dictionary ) );
        }

        return list;
    }

    private Long queryVOParentVOId(DictionaryVO dictionaryVO) {
        if ( dictionaryVO == null ) {
            return null;
        }
        DictionaryVO parentVO = dictionaryVO.getParentVO();
        if ( parentVO == null ) {
            return null;
        }
        Long id = parentVO.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected DictionaryVO dictionaryToDictionaryVO(Dictionary dictionary) {
        if ( dictionary == null ) {
            return null;
        }

        DictionaryVO dictionaryVO = new DictionaryVO();

        dictionaryVO.setId( dictionary.getParent() );

        return dictionaryVO;
    }
}
