package com.mycompany.teacher.model.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.teacher.model.entity.Settings;

@Repository("settingsRepositoryImpl")
public class SettingsRepositoryImpl extends BaeseRepository<Settings>{

	@Override
	public Settings byId(Serializable id) {
		return getSession().get(Settings.class, id);
	}

	@Override
	public List<Settings> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
