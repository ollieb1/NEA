import { API_BASE_URL, ACCESS_TOKEN } from '../constants';

{/* Setting up api requests */}
const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })

    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN)) 
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

{/* Login Request */}
export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}


export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/user/me",
        method: 'GET'
    });
}

{/* Gets users' profile */}
export function getUserProfile(username) {
    return request({
        url: API_BASE_URL + "/users/" + username,
        method: 'GET'
    });
}

{/* Gets all bonds */}
export function getAllBonds(page, size) {
    return request({
        url: `${API_BASE_URL}/bonds?page=${page - 1}&size=${size}`,
        method: 'GET'
    });
}

{/* Gets ID of a bond */}
export function getBond(id) {
    return request({
        url: `${API_BASE_URL}/bonds/${id}`,
        method: 'GET'
    });
}

{/* Price Request */}
export function price(priceRequest) {
    return request({
        url: `${API_BASE_URL}/bonds/price`,
        method: 'POST',
        body: JSON.stringify(priceRequest)
    });
}
{/* Add bond Request */}
export function add(addRequest) {
    return request({
        url: `${API_BASE_URL}/bonds/`,
        method: 'POST',
        body: JSON.stringify(addRequest)
    });
}