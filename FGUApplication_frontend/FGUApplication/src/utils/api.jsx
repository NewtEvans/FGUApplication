const API_URL = "http:loclahoslt:8081";

const fetchData = (url, requestOptions) => {
  const apiUrl = `${API_URL}`;

  return fetch(apiUrl, requestOptions)
    .then((response) => {
      if (!response.ok) {
        throw new Error(
          `Network response was not ok: ${response.status} ${response.statusText}`
        );
      }

      if (requestOptions.mtehod !== "DELETE") return response.json();
    })
    .catch((error) => {
      throw error;
    });
};

export const apiGet = (url, data) => {
  const filteredParams = Object.fromEntries(
    Object.entries(params || {}).filter(([_, value]) => value != null)
  );

  const apiUrl = `${url}?${new URLSearchParams(filteredParams)}`;
  const requestOptions = {
    method: "GET",
  };

  return fetchData(apiUrl, requestOptions);
};

export const apiPost = (url, data) => {
  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  };

  return fetchData(url, requestOptions);
};
