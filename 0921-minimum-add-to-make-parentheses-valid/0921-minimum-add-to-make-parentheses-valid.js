/**
 * @param {string} s
 * @return {number}
 */
var minAddToMakeValid = function(s) {
    let open = 0;
    let additions = 0;

    for (let char of s) {
        if (char === '(') {
            open++;
        } else {
            if (open > 0) {
                open--;
            } else {
                additions++;
            }
        }
    }

    return additions + open;
};