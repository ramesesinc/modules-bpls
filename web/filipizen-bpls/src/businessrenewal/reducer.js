export const ACTIONS = {
  SET_APP: "SET_APP",
  SET_CONTACT: "SET_CONTACT",
  UPDATE_APP_INFOS: "UPDATE_APP_INFOS",
};

export const initialState = {
  bin: null,
  app: {objid: "0001", lobs:[], infos:[], newinfos: [], redflags:[]},
  contact: {},
};

const reducer = (draft, action) => {
  switch (action.type) {
    case ACTIONS.SET_APP:
      draft.app = action.app;
      draft.bin = action.app.bin;
      return;
    
      case ACTIONS.UPDATE_APP_INFOS:
      draft.app = action.app;
      draft.app.newinfos.push(...action.infos);
      draft.bin = action.app.bin;
      return;

    case ACTIONS.SET_CONTACT:
      draft.contact = action.contact;
      return;

    default:
      return draft;
  }
};

export default reducer;
