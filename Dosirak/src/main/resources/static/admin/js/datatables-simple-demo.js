window.addEventListener('DOMContentLoaded', event => {
    // 데이터 테이블 초기화
    const datatablesSimple = document.getElementById('datatablesSimple');
    let dataTable;
    if (datatablesSimple) {
        // 검색 기능을 활성화하여 테이블을 초기화합니다.
        dataTable = new simpleDatatables.DataTable(datatablesSimple, {
            searchable: true,
        });
    }
});