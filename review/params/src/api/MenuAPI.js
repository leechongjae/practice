import menus from '../data/menu-detail.json';

/* json 파일로부터 전체 메뉴 리스트 반환 */
export function getMenuList() {
    // json으로 파싱 된 데이터를 반환한다. 
    return menus;
}

/* MenuDetails에서 넘겨준 메뉴코드 값과 일치하는 메뉴 객체를 반환 */
export function getMenuDetail(menuCode) {
    return menus.filter(menu => menu.menuCode === parseInt(menuCode))[0];
}

export function searchMenu(searchMenuName) {
    return menus.filter(menu => menu.menuName.match(searchMenuName));
}