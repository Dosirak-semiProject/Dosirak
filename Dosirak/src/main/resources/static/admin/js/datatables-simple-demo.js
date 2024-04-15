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

    // 검색 입력 필드와 돋보기 버튼을 선택합니다.
    const searchInput = document.querySelector('.form-control');
    const searchButton = document.getElementById('btnNavbarSearch');

    // 검색 입력 필드에서 엔터 키 이벤트를 감지합니다.
    if (searchInput) {
        searchInput.addEventListener('keydown', function(event) {
            // 엔터 키를 누르면
            if (event.key === 'Enter') {
                // 기본 동작(폼 제출)을 막습니다.
                event.preventDefault();

                // 입력된 검색어를 가져와 데이터 테이블에 적용합니다.
                const searchValue = searchInput.value;
                if (dataTable) {
                    dataTable.search(searchValue);
                }
            }
        });
    }

    // 돋보기 버튼 클릭 이벤트를 추가합니다.
    if (searchButton) {
        searchButton.addEventListener('click', function() {
            // 돋보기를 클릭할 때 입력된 검색어를 데이터 테이블에 적용합니다.
            const searchValue = searchInput.value;
            if (dataTable) {
                dataTable.search(searchValue);
            }
        });
    }
});